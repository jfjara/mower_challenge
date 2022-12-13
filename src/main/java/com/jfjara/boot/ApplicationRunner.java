package com.jfjara.boot;

import com.jfjara.application.usecase.InputDataUseCase;
import com.jfjara.application.usecase.MainUseCase;
import com.jfjara.application.usecase.OutputDataUseCase;
import com.jfjara.application.usecase.ParseDataUseCase;
import com.jfjara.infraestructure.keyboard.KeyboardInputRepository;
import com.jfjara.infraestructure.parser.CustomParserRepository;
import com.jfjara.infraestructure.terminal.TerminalOutputRepository;

public class ApplicationRunner {

    public void run() {
        MainUseCase mainUseCase = new MainUseCase(
                new InputDataUseCase(new KeyboardInputRepository(), new TerminalOutputRepository()),
                new ParseDataUseCase(new CustomParserRepository()),
                new OutputDataUseCase(new TerminalOutputRepository())
        );
        mainUseCase.execute();
    }

}
