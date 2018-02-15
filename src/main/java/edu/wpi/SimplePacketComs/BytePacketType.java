package edu.wpi.SimplePacketComs;

public  class BytePacketType extends PacketType{
	int idOfCommand=0;
	Number [] downstream;
	Number [] upstream;
	boolean done=false;
	boolean started = false;
	public PacketProcessor processor;
	public BytePacketType(int id, int size){
		super(id);
		processor=new BytePacketProcessor(size);
		downstream=new Number[processor.numValues];
		upstream=new Number[processor.numValues];
	}
	
}