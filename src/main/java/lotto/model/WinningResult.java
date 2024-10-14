package lotto.model;

import lotto.util.Rank;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningResult {
    private final Map<Rank, Integer> result;

    public WinningResult() {
        result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    } // WinningResult

    public void updateResult(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    } // updateResult

    public int getRank(Rank rank) {
        return result.get(rank);
    } // getRank

    @Override
    public String toString() {
        return Stream.of(Rank.values())
                .filter(rank -> rank.ordinal() <= Rank.FIFTH.ordinal())
                .map(rank -> rank.getMessage() + result.get(rank) + "개")
                .collect(Collectors.joining("\n"));
    } // toString
} // class