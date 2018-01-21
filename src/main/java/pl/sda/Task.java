package pl.sda;

import java.time.LocalDate;

public class Task {
    private String title;
    private LocalDate creationDate;
    private LocalDate executeDate;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setExecuteDate(LocalDate executeDate) {
        this.executeDate = executeDate;
    }

    public LocalDate getExecuteDate() {
        return executeDate;
    }
}
