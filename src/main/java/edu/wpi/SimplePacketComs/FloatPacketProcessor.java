package edu.wpi.SimplePacketComs;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class FloatPacketProcessor  extends PacketProcessor{

	public FloatPacketProcessor(int size){
		 packetSize = size;
		 numberOfBytesPerValue = 4;
		 numValues = (packetSize / numberOfBytesPerValue) - (4/numberOfBytesPerValue);
		 
	}
	Number[] parse(byte[] bytes) {
		Number[] returnValues = new Number[numValues];

		// println "Parsing packet"
		for (int i = 0; i < numValues; i++) {
			int baseIndex = (4 * i) + 4;
			returnValues[i] = ByteBuffer.wrap(bytes).order(be).getFloat(baseIndex);
		}

		return returnValues;
	}

	byte[] command(int idOfCommand, Number[] values) {
		byte[] message = new byte[packetSize];
		ByteBuffer.wrap(message).order(be).putInt(0, idOfCommand).array();
		for (int i = 0; i < numValues && i < values.length; i++) {
			int baseIndex = (4 * i) + 4;
			ByteBuffer.wrap(message).order(be).putFloat(baseIndex, (float)values[i]).array();
		}
		return message;
	}

}
