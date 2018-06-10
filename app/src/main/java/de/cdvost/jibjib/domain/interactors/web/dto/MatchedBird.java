package de.cdvost.jibjib.domain.interactors.web.dto;

import de.cdvost.jibjib.repository.room.model.entity.Bird;

public class MatchedBird {

    private Bird bird;
    private float accuracy;

    public MatchedBird(Bird bird, float accuracy) {
        this.bird = bird;
        this.accuracy = accuracy;
    }

    public Bird getBird() {
        return bird;
    }

    public float getAccuracy() {
        return accuracy;
    }

}