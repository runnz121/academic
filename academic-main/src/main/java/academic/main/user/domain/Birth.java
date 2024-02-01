package academic.main.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Birth {

    @Column(name = "birth_date")
    private String birthDate;

    public static Birth from(String birthDate) {
        return new Birth(birthDate);
    }

    private Birth(String birthDate) {
        this.birthDate = birthDate;
    }
}
