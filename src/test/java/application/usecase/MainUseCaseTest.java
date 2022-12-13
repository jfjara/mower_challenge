package application.usecase;

import com.jfjara.application.usecase.InputDataUseCase;
import com.jfjara.application.usecase.MainUseCase;
import com.jfjara.application.usecase.OutputDataUseCase;
import com.jfjara.application.usecase.ParseDataUseCase;
import com.jfjara.domain.model.CardinalDirectionsEnum;
import com.jfjara.domain.model.MowerPosition;
import com.jfjara.infraestructure.parser.CustomParserRepository;
import com.jfjara.mocks.MockInputRepository;
import com.jfjara.mocks.MockOutputRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MainUseCaseTest {

    @Test
    public void test_calculate_last_position_with_valid_input() {
        MainUseCase useCase = new MainUseCase(
                new InputDataUseCase(new MockInputRepository(), new MockOutputRepository()),
                new ParseDataUseCase(new CustomParserRepository()),
                new OutputDataUseCase(new MockOutputRepository()));
        List<MowerPosition> endPositions = useCase.execute();
        Assert.assertTrue(endPositions != null && !endPositions.isEmpty());
        Assert.assertEquals(2, endPositions.size());
        Assert.assertEquals(1, endPositions.get(0).getX());
        Assert.assertEquals(3, endPositions.get(0).getY());
        Assert.assertEquals(CardinalDirectionsEnum.N, endPositions.get(0).getDirection());
        Assert.assertEquals(5, endPositions.get(1).getX());
        Assert.assertEquals(1, endPositions.get(1).getY());
        Assert.assertEquals(CardinalDirectionsEnum.E, endPositions.get(1).getDirection());
    }

    @Test
    public void test_calculate_other_last_position_with_valid_input() {
        MainUseCase useCase = new MainUseCase(
                new InputDataUseCase(new MockInputRepository(Arrays.asList("8 4", "4 2 E", "MLMMRMMRMMMLM", "3 3 S", "MMMMLMLM")), new MockOutputRepository()),
                new ParseDataUseCase(new CustomParserRepository()),
                new OutputDataUseCase(new MockOutputRepository()));
        List<MowerPosition> endPositions = useCase.execute();
        Assert.assertTrue(endPositions != null && !endPositions.isEmpty());
        Assert.assertEquals(2, endPositions.size());
        Assert.assertEquals(8, endPositions.get(0).getX());
        Assert.assertEquals(1, endPositions.get(0).getY());
        Assert.assertEquals(CardinalDirectionsEnum.E, endPositions.get(0).getDirection());
        Assert.assertEquals(4, endPositions.get(1).getX());
        Assert.assertEquals(1, endPositions.get(1).getY());
        Assert.assertEquals(CardinalDirectionsEnum.N, endPositions.get(1).getDirection());
    }

    @Test
    public void test_clockwise_valid_input() {
        MainUseCase useCase = new MainUseCase(
                new InputDataUseCase(new MockInputRepository(Arrays.asList("4 4", "0 0 E", "LMMMMRMMMMRMMMMRMMMM", "4 4 N", "LLMMMMRMMMMRMMMMRMMMM")), new MockOutputRepository()),
                new ParseDataUseCase(new CustomParserRepository()),
                new OutputDataUseCase(new MockOutputRepository()));
        List<MowerPosition> endPositions = useCase.execute();
        Assert.assertTrue(endPositions != null && !endPositions.isEmpty());
        Assert.assertEquals(2, endPositions.size());
        Assert.assertEquals(0, endPositions.get(0).getX());
        Assert.assertEquals(0, endPositions.get(0).getY());
        Assert.assertEquals(CardinalDirectionsEnum.W, endPositions.get(0).getDirection());
        Assert.assertEquals(4, endPositions.get(1).getX());
        Assert.assertEquals(4, endPositions.get(1).getY());
        Assert.assertEquals(CardinalDirectionsEnum.E, endPositions.get(1).getDirection());
    }

    @Test
    public void test_corner_to_corner_valid_input() {
        MainUseCase useCase = new MainUseCase(
                new InputDataUseCase(new MockInputRepository(Arrays.asList("5 5", "5 0 E", "LLMRMLMRMLMRMLMRMLMRM",
                        "5 5 N", "LMLMRMLMRMLMRMLMRMLM")), new MockOutputRepository()),
                new ParseDataUseCase(new CustomParserRepository()),
                new OutputDataUseCase(new MockOutputRepository()));
        List<MowerPosition> endPositions = useCase.execute();
        Assert.assertTrue(endPositions != null && !endPositions.isEmpty());
        Assert.assertEquals(2, endPositions.size());
        Assert.assertEquals(0, endPositions.get(0).getX());
        Assert.assertEquals(5, endPositions.get(0).getY());
        Assert.assertEquals(CardinalDirectionsEnum.N, endPositions.get(0).getDirection());
        Assert.assertEquals(0, endPositions.get(1).getX());
        Assert.assertEquals(0, endPositions.get(1).getY());
        Assert.assertEquals(CardinalDirectionsEnum.S, endPositions.get(1).getDirection());
    }

}
