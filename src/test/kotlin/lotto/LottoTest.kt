package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.Wallet
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또는 개당 1000원이다`() {
        // given
        val wallet = Wallet(1000)
        val lottos = Lottos.generateAutoLottos(wallet.getAbleToBuyAutoLottoCounts())

        // when
        val purchaseLottos = lottos.toList()

        // then
        assertThat(purchaseLottos.size).isEqualTo(1)
    }

    @Test
    fun `로또는 6개 숫자로 이루어져 있다`() {
        // given
        val lottoNumbers = LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(lottoNumbers)

        // when
        val matchingCount = lotto.getLottoNumbers().getMatchingCount(lottoNumbers)

        // then
        assertThat(matchingCount).isEqualTo(6)
    }

    @Test
    fun `로또가 6개의 숫자로 이루어 지지 않았다면 에러`() {
        // given
        val actual =
            runCatching { Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 4, 5, 6, 7))) }.exceptionOrNull()

        // then
        assertThat(actual).hasMessageContaining("숫자가 6개가 들어와야 합니다.")
    }

    @Test
    fun `로또 번호에는 중복 된 숫자로 이루어질 수 없다`() {
        // given
        val actual =
            runCatching { Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 4, 6, 6))) }.exceptionOrNull()

        // then
        assertThat(actual).hasMessageContaining("중복 된 숫자는 들어올 수 없습니다.")
    }

    @Test
    fun `14000원으로 로또 14장을 살 수 있다`() {
        // given
        val wallet = Wallet(14000)
        val lottos = Lottos.generateAutoLottos(wallet.getAbleToBuyAutoLottoCounts())

        // when
        val purchaseLottos = lottos.toList()

        // then
        assertThat(purchaseLottos.size).isEqualTo(14)
    }
}