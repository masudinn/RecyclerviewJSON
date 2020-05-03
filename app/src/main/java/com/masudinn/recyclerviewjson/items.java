package com.masudinn.recyclerviewjson;

public class items {
    private String mImageurl;
    private String mCreator;
    private String tags;
    private int unduh;
    private int mLikes;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getUnduh() {
        return unduh;
    }

    public void setUnduh(int unduh) {
        this.unduh = unduh;
    }

    public items(String Imageurl, String creator , int like, String tags, int unduh){
        mImageurl = Imageurl;
        mCreator = creator;
        mLikes = like;
        this.tags = tags;
        this.unduh = unduh;
    }

    public String getmImageurl() {
        return mImageurl;
    }

    public void setmImageurl(String mImageurl) {
        this.mImageurl = mImageurl;
    }

    public String getmCreator() {
        return mCreator;
    }

    public void setmCreator(String mCreator) {
        this.mCreator = mCreator;
    }

    public int getmLikes() {
        return mLikes;
    }

    public void setmLikes(int mLikes) {
        this.mLikes = mLikes;
    }
}
