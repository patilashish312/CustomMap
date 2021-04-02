package app.test;

public class InstrumentIdentifier {
	
	String instrument_id;
	public Instrument getInstrument() {
		return this.ins;
	}
	public String getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(String instrument_id) {
		this.instrument_id = instrument_id;
	}	
	Instrument ins;
	public InstrumentIdentifier(String a) {
		this.instrument_id=a;
		ins=Instrument.valueOf(a);
	}	
	@Override
	public String toString() {
		return "InstrumentIdentifier [instrument_id=" + instrument_id + ", ins=" + ins + "]";
	}
	
}
