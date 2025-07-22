package com.maven6;
public class OnSiteCourse extends Course {
    private String room;
    private int maxQuota;

    public OnSiteCourse(String title, int duration, String professor, String room, int maxQuota) {
        super(title, duration, professor);
        setRoom(room);
        setMaxQuota(maxQuota);
    }

    @Override
    public String showInformation() {
        return "[On-Site] " + super.showInformation() + " - Room: " + room + " - Max Quota: " + maxQuota;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getMaxQuota() {
        return maxQuota;
    }

    public void setMaxQuota(int maxQuota) {
        if (maxQuota >= 0) {
            this.maxQuota = maxQuota;
        } else {
            throw new IllegalArgumentException("El cupo no puede ser negativo.");
        }
    }
}
