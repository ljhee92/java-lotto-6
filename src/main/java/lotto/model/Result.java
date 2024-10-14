package lotto.model;

import lotto.util.Rank;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Result {
    private final Map<Rank, Integer> result;

    public Result() {
        result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    } // Result

    public void updateResult(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public int getRank(Rank rank) {
        return result.get(rank);
    }

    @Override
    public String toString() {
        return Stream.of(Rank.values())
                .filter(rank -> rank.ordinal() <= Rank.FIFTH.ordinal())
                .map(rank -> rank.getMessage() + result.get(rank) + "개")
                .collect(Collectors.joining("\n"));
    }
} // class