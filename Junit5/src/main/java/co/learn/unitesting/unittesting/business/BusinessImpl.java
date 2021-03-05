package co.learn.unitesting.unittesting.business;

import java.util.List;

import co.learn.unitesting.unittesting.data.DataServices;
import co.learn.unitesting.unittesting.data.DataServicesImpl;



public class BusinessImpl {
	
	private DataServices dataServices = new DataServicesImpl();

	public int calculateSum(List<Integer> data) {
		return data.stream().parallel().reduce(0,Integer::sum);
	}
	
	public int calculateSumRange(int begin,int finish) {
		return dataServices.getRange(begin, finish).stream().parallel().reduce(0,Integer::sum);
	}
}
