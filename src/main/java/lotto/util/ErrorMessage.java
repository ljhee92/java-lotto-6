package lotto.util;

public class ErrorMessage {
    public static final String PREFIX = "[ERROR] ";
    public static final String LOTTO_MUST_BE_SIX_NUMBERS = PREFIX + "로또 번호는 숫자 6개여야 합니다.";
    public static final String LOTTO_MUST_BE_BETWEEN_ONE_AND_FOURTYFIVE = PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_MUST_NOT_BE_DUPLICATE = PREFIX + "로또 번호는 중복되지 않는 숫자여야 합니다.";
    public static final String AMOUNT_MUST_BE_NUMBER = PREFIX + "구입금액은 숫자만 입력해야 합니다.";
    public static final String BONUS_MUST_BE_ONLY_ONE_NUMBER = PREFIX + "보너스 번호는 숫자 1개만 입력 가능 합니다.";
    public static final String BONUS_MUST_BE_BETWEEN_ONE_AND_FOURTYFIVE = PREFIX + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_MUST_NOT_BE_DUPLICATE_OF_LOTTO = PREFIX + "보너스 번호는 로또 번호와 중복되지 않는 숫자여야 합니다.";
    public static final String AMOUNT_MUST_BE_DIVIDE_INTO_1000 = PREFIX + "구입금액은 1,000원 단위로 입력해야 합니다.";
} // class