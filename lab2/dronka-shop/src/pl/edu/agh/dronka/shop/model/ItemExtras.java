package pl.edu.agh.dronka.shop.model;

import java.util.Date;

public class ItemExtras extends Item {

    private boolean hardCover;
    private int pages;

    private boolean mobile;
    private boolean guarantee;

    private Date isEatable;
    private MusicType musicType;

    private boolean withVideo;

    public ItemExtras() {

    }

    public ItemExtras(String name, Category category, int price, int quantity) {
        super(name, category, price, quantity);
    }

    public boolean isHardCover() {
        return hardCover;
    }

    public void setHardCover(boolean hardCover) {
        this.hardCover = hardCover;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }

    public Date getIsEatable() {
        return isEatable;
    }

    public void setIsEatable(Date isEatable) {
        this.isEatable = isEatable;
    }

    public boolean isWithVideo() {
        return withVideo;
    }

    public void setWithVideo(boolean withVideo) {
        this.withVideo = withVideo;
    }

    public MusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }
}
