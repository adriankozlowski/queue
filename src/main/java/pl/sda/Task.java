package pl.sda;

import java.util.Date;

public class Task {
    private String title;
    private Date creationDate;
    private Date executeDate;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setExecuteDate(Date executeDate) {
        this.executeDate = executeDate;
    }

    public Date getExecuteDate() {
        return executeDate;
    }
}
