package application.executor;

import com.jfjara.application.executor.MowerCommandExecutor;
import com.jfjara.domain.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MowerCommandExecutorTest {

    private MowerCommandExecutor mowerCommandExecutor = new MowerCommandExecutor();

    @Test
    public void test_90_degree_command_rotate_left() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.N)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerDirectionCommand('L')))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(1, updatedPosition.getX());
        Assert.assertEquals(1, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.W, updatedPosition.getDirection());
    }

    @Test
    public void test_90_degree_command_rotate_right() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.N)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerDirectionCommand('R')))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(1, updatedPosition.getX());
        Assert.assertEquals(1, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.E, updatedPosition.getDirection());
    }

    @Test
    public void test_degree_command_rotate_left() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.N)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerDirectionCommand('L'), new MowerDirectionCommand('L')))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(1, updatedPosition.getX());
        Assert.assertEquals(1, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.S, updatedPosition.getDirection());
    }

    @Test
    public void test_180_degree_command_rotate_right() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.S)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerDirectionCommand('R'), new MowerDirectionCommand('R')))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(1, updatedPosition.getX());
        Assert.assertEquals(1, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.N, updatedPosition.getDirection());
    }

    @Test
    public void test_only_180_degree_command_rotate_right() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.S)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerDirectionCommand('R'), new MowerDirectionCommand('R')))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(1, updatedPosition.getX());
        Assert.assertEquals(1, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.N, updatedPosition.getDirection());
    }

    @Test
    public void test_move_one_position_command_to_north() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.N)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerMovementCommand()))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(1, updatedPosition.getX());
        Assert.assertEquals(2, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.N, updatedPosition.getDirection());
    }

    @Test
    public void test_move_one_position_command_to_south() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.S)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerMovementCommand()))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(1, updatedPosition.getX());
        Assert.assertEquals(0, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.S, updatedPosition.getDirection());
    }

    @Test
    public void test_move_one_position_command_to_west() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.W)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerMovementCommand()))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(0, updatedPosition.getX());
        Assert.assertEquals(1, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.W, updatedPosition.getDirection());
    }

    @Test
    public void test_move_one_position_command_to_east() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.E)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerMovementCommand()))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(2, updatedPosition.getX());
        Assert.assertEquals(1, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.E, updatedPosition.getDirection());
    }

    @Test
    public void test_move_no_trespassing_board_north() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.N)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand()))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(1, updatedPosition.getX());
        Assert.assertEquals(3, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.N, updatedPosition.getDirection());
    }

    @Test
    public void test_move_no_trespassing_board_south() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.S)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand()))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(1, updatedPosition.getX());
        Assert.assertEquals(0, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.S, updatedPosition.getDirection());
    }

    @Test
    public void test_move_no_trespassing_board_west() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.W)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand()))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(0, updatedPosition.getX());
        Assert.assertEquals(1, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.W, updatedPosition.getDirection());
    }

    @Test
    public void test_move_no_trespassing_board_east() {
        MowerPosition updatedPosition = mowerCommandExecutor.executeMowerCommand(
                new MowerCommandsInput.Builder()
                        .mowerPosition(new MowerPosition.Builder()
                                .x(1)
                                .y(1)
                                .direction(CardinalDirectionsEnum.E)
                                .build())
                        .mowerCommands(Arrays.asList(new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand(),
                                new MowerMovementCommand()))
                        .build(),
                new BoardDimension.Builder().width(3).height(3).build());
        Assert.assertTrue(updatedPosition != null);
        Assert.assertEquals(3, updatedPosition.getX());
        Assert.assertEquals(1, updatedPosition.getY());
        Assert.assertEquals(CardinalDirectionsEnum.E, updatedPosition.getDirection());
    }

}
