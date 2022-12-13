package application.usecase;

import com.jfjara.application.usecase.InputDataUseCase;
import com.jfjara.domain.repository.InputRepository;
import com.jfjara.domain.repository.OutputRepository;
import com.jfjara.mocks.MockInputRepository;
import com.jfjara.mocks.MockOutputRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InputDataCaseUseTest {

    private InputRepository inputRepository = new MockInputRepository();
    private OutputRepository outputRepository = new MockOutputRepository();
    private InputDataUseCase inputDataUseCase = new InputDataUseCase(inputRepository, outputRepository);

    @Test
    public void obtain_input_data_ok_test() {
        List<String> data = inputDataUseCase.execute();
        Assert.assertTrue(data != null && !data.isEmpty());
        Assert.assertTrue(data.size() == 5);
    }

}
