package nextstep.subway.policy.payment;

import nextstep.subway.domain.policy.discount.ChildrenDiscountPolicy;
import nextstep.subway.domain.policy.discount.DiscountPolicy;
import nextstep.subway.domain.policy.discount.YouthDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPolicyTest {
    private static final int FARE = 1350;
    private static final DiscountPolicy ageFarePolicy = new ChildrenDiscountPolicy(new YouthDiscountPolicy(null));

    @Test
    @DisplayName("1350원의 요금이 발생했을 때, 어린이는 850원을 낸다.")
    void calculate_children() {
        // given
        int age = 9;

        // when
        int fare = ageFarePolicy.calculate(age, FARE);

        // then
        assertThat(fare).isEqualTo(850);
    }

    @Test
    @DisplayName("1350원의 요금이 발생했을 때, 청소년의 요금은 1150원이다.")
    void calculate_youth() {
        // given
        int age = 17;

        // when
        int fare = ageFarePolicy.calculate(age, FARE);

        // then
        assertThat(fare).isEqualTo(1150);
    }

    @Test
    @DisplayName("성인은 1350원의 요금을 낸다.")
    void calculate_adult() {
        // given
        int age = 33;

        // when
        int fare = ageFarePolicy.calculate(age, FARE);

        // then
        assertThat(fare).isEqualTo(1350);
    }
}
