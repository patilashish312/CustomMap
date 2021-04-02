package app.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * This was one of interview questions asked about if we can implement an interface 
 * which return Map based on input values provided in method argument which is Set.
 * @author ashishpatil
 *
 */


public class InstrumentProviderImpl implements InstrumentProvider {

	Map<InstrumentIdentifier, Instrument> mainCache;

	public Map<InstrumentIdentifier, Instrument> getMainCache() {
		return mainCache;
	}

	public void setMainCache(Map<InstrumentIdentifier, Instrument> mainCache) {
		this.mainCache = mainCache;
	}

	@Override
	public Map<InstrumentIdentifier, Instrument> getInstruments(Set<InstrumentIdentifier> instrumentIdentifiers) {
		Map<InstrumentIdentifier, Instrument> tempMap = new HashMap<InstrumentIdentifier, Instrument>();
		tempMap.putAll(getMainCache());
		instrumentIdentifiers.forEach(a -> {
			tempMap.putIfAbsent(a, a.getInstrument());
			getMainCache().putIfAbsent(a, a.getInstrument());
		});
		tempMap.keySet().retainAll(instrumentIdentifiers);
		return tempMap;

	}

	public static void main(String[] args) {
		InstrumentIdentifier identifier = new InstrumentIdentifier("Equity");
		InstrumentIdentifier identifier1 = new InstrumentIdentifier("FI");
		InstrumentIdentifier identifier2 = new InstrumentIdentifier("Other");
		InstrumentIdentifier identifier3 = new InstrumentIdentifier("Other");
		InstrumentIdentifier id4=new InstrumentIdentifier("Other2");
		//System.out.println(identifier.getInstrument().hashCode());
		//System.out.println(identifier1.getInstrument_id().hashCode());
		//System.out.println(identifier2.getInstrument().hashCode());
		//System.out.println(identifier3.getInstrument().hashCode());
		InstrumentProviderImpl ab = new InstrumentProviderImpl();
		Map<InstrumentIdentifier, Instrument> map=new HashMap<InstrumentIdentifier, Instrument>();
		ab.setMainCache(map);
		ab.getMainCache().put(id4,id4.getInstrument());
		ab.getMainCache().put(identifier1,identifier1.getInstrument());
		ab.getMainCache().put(identifier2,identifier2.getInstrument());
		ab.getMainCache().put(identifier3,identifier3.getInstrument());
		Set<InstrumentIdentifier> s=new HashSet<InstrumentIdentifier>();
		s=Stream.of(identifier/*,identifier1,identifier2,identifier3*/).collect(Collectors.toSet());
		System.out.println(ab.getInstruments(s));
		System.out.println(ab.getMainCache());
		// ab.getMainCache().putIfAbsent(identifier, identifier.in)
	}

}
