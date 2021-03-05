package co.learn.unitesting.unittesting.data;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataServicesImpl implements DataServices {

	@Override
	public List<Integer> getRange(int begin, int finish) {
		return IntStream.rangeClosed(begin, finish).mapToObj(b -> new Integer(b)).collect(Collectors.toList());
	}

}
