package co.learn.unitesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import co.learn.unitesting.unittesting.data.DataServices;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BusinessImplTest {

	@InjectMocks
	private BusinessImpl businessImpl = new BusinessImpl();

	@Mock
	private DataServices dataServices;

	@Test
	public void testCalculateSum1() throws Exception {
		when(dataServices.getRange(1, 3)).thenReturn(Arrays.asList(1, 2, 3));

		assertEquals(6, businessImpl.calculateSum(dataServices.getRange(1, 3)));
	}

	@Test
	public void testCalculateSum2() throws Exception {
		when(dataServices.getRange(0, 0)).thenReturn(Arrays.asList(0));

		assertEquals(0, businessImpl.calculateSum(dataServices.getRange(0, 0)));
	}

	@Test
	public void testCalculateSum5() throws Exception {
		when(dataServices.getRange(1, 2)).thenReturn(Arrays.asList(1, 2));

		assertEquals(3, businessImpl.calculateSum(dataServices.getRange(1, 2)));
	}

	@Test
	public void testCalculateSum4() throws Exception {
		when(dataServices.getRange(1, 5)).thenReturn(Arrays.asList(1, 2, 3, 4, 5));

		assertEquals(15, businessImpl.calculateSum(dataServices.getRange(1, 5)));
	}

	@Test
	public void testCalculateSum6() throws Exception {
		when(dataServices.getRange(Mockito.anyInt(), Mockito.anyInt())).thenReturn(Arrays.asList(1, 2, 3, 4, 5));

		assertEquals(15, businessImpl.calculateSum(dataServices.getRange(-1, -5)));
	}

	@Test
	public void testCalculateSumveryfy() throws Exception {

		List<Integer> list1 = dataServices.getRange(1, 1);
		List<Integer> list2 = dataServices.getRange(1, 10);

		Mockito.verify(dataServices).getRange(1, 1);
		Mockito.verify(dataServices,Mockito.times(2)).getRange(Mockito.anyInt(), Mockito.anyInt());
		Mockito.verify(dataServices,Mockito.atLeast(1)).getRange(Mockito.anyInt(), Mockito.anyInt());
		Mockito.verify(dataServices,Mockito.atLeastOnce()).getRange(Mockito.anyInt(), Mockito.anyInt());
		Mockito.verify(dataServices,Mockito.atMost(2)).getRange(Mockito.anyInt(), Mockito.anyInt());
		Mockito.verify(dataServices,Mockito.never()).getRange(2, 3);
	}
	
	@Test
	public void testCalculateSumArgCapture() throws Exception {

		List<Integer> list1 = dataServices.getRange(1, 4);
		List<Integer> list2 = dataServices.getRange(7, 14);

		ArgumentCaptor<Integer> arg1 = ArgumentCaptor.forClass(Integer.class);
		
		Mockito.verify(dataServices,Mockito.times(2)).getRange(arg1.capture(),arg1.capture());
		
		System.out.println("el argumento es "+arg1.getAllValues());
		
		assertEquals(1, arg1.getAllValues().get(0));
	}
	
	@Test
	public void mocking() {
		ArrayList arrayListMock = Mockito.mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}

	@Test
	public void spying() {
		ArrayList arrayListSpy = Mockito.spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//5
		
		Mockito.verify(arrayListSpy).add("Test4");
	}

}
