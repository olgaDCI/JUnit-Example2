import com.example.Calculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ExampleTest {

    @Test
    public void ExampleTest(){
       // fail();
        Calculator calculator = new Calculator();
        int result = calculator.integerDivision(4,2);;
        assertEquals(2,result,"4/2 should have returned 2");
    }

    @Test
    public void CalculationTestMock(){ //understanding Mock
        // fail();

        Calculator mockCalculator = mock(Calculator.class);
        when(mockCalculator.add(1,2)).thenReturn(3);
        int result = mockCalculator.add(1,2);
        System.out.println(result);

       assertEquals(3,result);
       verify(mockCalculator,times(1)).add(1,2);
       verify(mockCalculator,never()).multiply(anyInt(),anyInt());
    }

    @Test
    public void CalculationTestSpy() { //understanding Spy
        // fail();
        Calculator calculator = new Calculator();
        Calculator spyCalculator = spy(calculator);

        int result = spyCalculator.add(1, 2);
        System.out.println(result);
        assertEquals(3, result);

        when(spyCalculator.multiply(2, 3)).thenReturn(10);


        int multiplication = spyCalculator.multiply(2, 3);
        System.out.println(multiplication);
        assertEquals(10, multiplication);

        verify(spyCalculator, times(1)).add(1, 2);
        verify(spyCalculator, times(1)).multiply(2, 3);

        doNothing().when(spyCalculator).doSomething(2, 3);
        spyCalculator.doSomething(2,3);

        verify(spyCalculator, times(1)).doSomething(2, 3);
    }

    @Test
    public void CalculationWithMockedListTest() {
        List<Integer> mockList = mock(List.class);

        when(mockList.size()).thenReturn(3);
        when(mockList.get(0)).thenReturn(1);
        when(mockList.get(1)).thenReturn(2);
        when(mockList.get(2)).thenReturn(3);

        Calculator calculatorService = new Calculator();
        int result = calculatorService.calculateTotal(mockList);

        assertEquals(6, result);  // 1 + 2 + 3 = 6
        assertEquals(3, mockList.size());
        assertEquals(1, mockList.get(0));
        assertEquals(2, mockList.get(1));
        assertEquals(3, mockList.get(2));


        verify(mockList, times(5)).size();
        verify(mockList, times(2)).get(0);
        verify(mockList, times(2)).get(1);
        verify(mockList, times(2)).get(2);
    }
}
