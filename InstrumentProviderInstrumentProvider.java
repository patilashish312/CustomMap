import java.util.Map;
import java.util.Set;

public interface InstrumentProvider {
	Map<InstrumentIdentifier,Instrument> getInstruments(Set<InstrumentIdentifier> instrumentIdentifiers);	
}
