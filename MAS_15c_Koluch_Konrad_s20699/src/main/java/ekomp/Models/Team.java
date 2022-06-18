package ekomp.Models;

import java.time.LocalDate;

public class Team extends ObjectPlusPlus {
    private LocalDate dateOfTeamCreated;
    private LocalDate dateOfTeamEnded;

    public Team(LocalDate dateOfTeamCreated) {
        this.dateOfTeamCreated = dateOfTeamCreated;
    }

    // Getery i Setery

    public LocalDate getDateOfTeamCreated() {
        return dateOfTeamCreated;
    }

    public void setDateOfTeamCreated(LocalDate dateOfTeamCreated) {
        this.dateOfTeamCreated = dateOfTeamCreated;
    }

    public LocalDate getDateOfTeamEnded() throws Exception {
        if(this.dateOfTeamEnded == null)
            throw new Exception("Zespół jeszcze się nie zakończył");
        return dateOfTeamEnded;
    }

    public void setDateOfTeamEnded(LocalDate dateOfTeamEnded) {
        this.dateOfTeamEnded = dateOfTeamEnded;
    }
}
