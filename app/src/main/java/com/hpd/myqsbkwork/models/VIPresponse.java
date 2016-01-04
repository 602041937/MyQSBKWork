package com.hpd.myqsbkwork.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 15-12-29.
 */
public class VIPresponse implements Serializable {


    private int count;
    private int err;
    private int total;
    private int page;
    private int refresh;

    @SerializedName("items")
    private List<ItemsEntity> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public static class ItemsEntity implements Serializable {
        private String high_url;
        private String format;

        @SerializedName("image")
        private Object image;
        private int published_at;
        private String tag;

        @SerializedName("user")
        private UserEntity user;
        private Object image_size;
        @SerializedName("id")
        private int id;

        @SerializedName("votes")
        private VotesEntity votes;
        private int created_at;
        @SerializedName("pic_url")
        private String pic_url;
        @SerializedName("content")
        private String content;
        private String state;
        @SerializedName("comments_count")
        private int comments_count;
        private String low_url;
        private boolean allow_comment;
        @SerializedName("share_count")
        private int share_count;
        @SerializedName("type")
        private String type;
        private int loop;
        private List<Integer> pic_size;

        public String getHigh_url() {
            return high_url;
        }

        public void setHigh_url(String high_url) {
            this.high_url = high_url;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public int getPublished_at() {
            return published_at;
        }

        public void setPublished_at(int published_at) {
            this.published_at = published_at;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public UserEntity getUser() {
            return user;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public Object getImage_size() {
            return image_size;
        }

        public void setImage_size(Object image_size) {
            this.image_size = image_size;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public VotesEntity getVotes() {
            return votes;
        }

        public void setVotes(VotesEntity votes) {
            this.votes = votes;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public String getLow_url() {
            return low_url;
        }

        public void setLow_url(String low_url) {
            this.low_url = low_url;
        }

        public boolean isAllow_comment() {
            return allow_comment;
        }

        public void setAllow_comment(boolean allow_comment) {
            this.allow_comment = allow_comment;
        }

        public int getShare_count() {
            return share_count;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getLoop() {
            return loop;
        }

        public void setLoop(int loop) {
            this.loop = loop;
        }

        public List<Integer> getPic_size() {
            return pic_size;
        }

        public void setPic_size(List<Integer> pic_size) {
            this.pic_size = pic_size;
        }

        public static class UserEntity implements Serializable {
            private int avatar_updated_at;
            private int last_visited_at;
            private int created_at;
            private String state;
            private String email;
            private String last_device;
            private String role;
            @SerializedName("login")
            private String login;
            @SerializedName("id")
            private int id;
            @SerializedName("icon")
            private String icon;

            public int getAvatar_updated_at() {
                return avatar_updated_at;
            }

            public void setAvatar_updated_at(int avatar_updated_at) {
                this.avatar_updated_at = avatar_updated_at;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getLast_device() {
                return last_device;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getLogin() {
                return login;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class VotesEntity implements Serializable {
            @SerializedName("down")
            private int down;
            @SerializedName("up")
            private int up;

            public int getDown() {
                return down;
            }

            public void setDown(int down) {
                this.down = down;
            }

            public int getUp() {
                return up;
            }

            public void setUp(int up) {
                this.up = up;
            }
        }
    }
}
