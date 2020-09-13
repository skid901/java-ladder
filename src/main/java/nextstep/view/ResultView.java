package nextstep.view;

import nextstep.dto.EntriesDTO;
import nextstep.dto.LadderDTO;
import nextstep.entity.LadderGame;

import java.util.List;

public class ResultView {

    private static final String NAME_FORMAT = "%6s";
    private static final String PEDAL = "-----|";
    private static final String NO_PEDAL = "     |";
    private static final String PLAY_RESULT_FORMAT = "%6s -> %6s\n";

    public void printEntryNames(EntriesDTO entriesDTO) {
        entriesDTO.getEntryNames().stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(System.out::print);
        System.out.println();
    }

    public void printLadder(LadderDTO ladderDTO) {
        ladderDTO.getLadder().forEach(this::printPedals);
    }

    private void printPedals(List<Boolean> line) {
        line.forEach(hasPedal -> System.out.print(hasPedal ? PEDAL : NO_PEDAL));
        System.out.println();
    }

    public void printPlayResults(EntriesDTO targetEntriesDTO, EntriesDTO arrivalEntries, LadderGame ladderGame) {
        System.out.println("실행 결과");
        targetEntriesDTO.getEntries().forEach(targetEntryDTO -> {
            String arrivalEntryName = ladderGame.play(targetEntryDTO.getName(), arrivalEntries.getEntryNames());
            System.out.printf(PLAY_RESULT_FORMAT, targetEntryDTO.getName(), arrivalEntryName);
        });
    }
}
