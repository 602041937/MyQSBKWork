package com.hpd.myqsbkwork.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 15-12-30.
 */
public class VIPCommentResponse {


    private int count;
    private int total;
    private int page;
    private int err;

    @SerializedName("items")
    private List<ItemsEntity> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public static class ItemsEntity {
        private boolean liked;
        private int floor;
        private int created_at;
        @SerializedName("content")
        private String content;
        @SerializedName("like_count")
        private int like_count;

        @SerializedName("user")
        private UserEntity user;
        @SerializedName("id")
        private int id;

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public UserEntity getUser() {
            return user;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static class UserEntity {
            private int last_visited_at;
            private int created_at;
            private String last_device;
            private String email;
            private String state;
            private String role;
            @SerializedName("login")
            private String login;
            @SerializedName("id")
            private int id;
            @SerializedName("icon")
            private String icon;

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

            public String getLast_device() {
                return last_device;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
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
    }
}
