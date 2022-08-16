package nextstep.subway.domain;

import nextstep.subway.domain.policy.payment.PaymentUtil;

import java.util.List;

public class Path {
    private Sections sections;

    public Path(Sections sections) {
        this.sections = sections;
    }

    public Sections getSections() {
        return sections;
    }

    public int extractDistance() {
        return sections.totalDistance();
    }

    public int extractDuration() {
        return sections.totalDuration();
    }

    public int extractFare() {
        return PaymentUtil.getFare(sections.totalDistance(), sections.MaxAdditionalCharge());
    }

    public List<Station> getStations() {
        return sections.getStations();
    }
}
