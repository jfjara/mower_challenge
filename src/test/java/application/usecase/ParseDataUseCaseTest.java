package application.usecase;

import com.jfjara.application.usecase.ParseDataUseCase;
import com.jfjara.domain.model.CardinalDirectionsEnum;
import com.jfjara.domain.model.CommandsInput;
import com.jfjara.domain.repository.ParserRepository;
import com.jfjara.infraestructure.parser.CustomParserRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ParseDataUseCaseTest {

    private ParserRepository parserRepository = new CustomParserRepository();

    @Test
    public void parse_valid_input_data_test() {
        ParseDataUseCase useCase = new ParseDataUseCase(parserRepository);
        CommandsInput result = useCase.execute(Arrays.asList("5 5", "1 2 N", "LMLMLMLMLMM", "3 3 E", "MMRMMRMRRM"));
        Assert.assertTrue(result != null);
        Assert.assertTrue(result.getBoardDimension() != null);
        Assert.assertEquals(5, result.getBoardDimension().getWidth());
        Assert.assertEquals(5, result.getBoardDimension().getHeight());
        Assert.assertTrue(result.getMowerCommandsInputs() != null);
        Assert.assertEquals(2, result.getMowerCommandsInputs().size());
        Assert.assertEquals(1, result.getMowerCommandsInputs().get(0).getMowerPosition().getX());
        Assert.assertEquals(2, result.getMowerCommandsInputs().get(0).getMowerPosition().getY());
        Assert.assertEquals(CardinalDirectionsEnum.N, result.getMowerCommandsInputs().get(0).getMowerPosition().getDirection());
        Assert.assertEquals(3, result.getMowerCommandsInputs().get(1).getMowerPosition().getX());
        Assert.assertEquals(3, result.getMowerCommandsInputs().get(1).getMowerPosition().getY());
        Assert.assertEquals(CardinalDirectionsEnum.E, result.getMowerCommandsInputs().get(1).getMowerPosition().getDirection());
        Assert.assertEquals(11, result.getMowerCommandsInputs().get(0).getMowerCommands().size());
        Assert.assertEquals(10, result.getMowerCommandsInputs().get(1).getMowerCommands().size());
    }
}
