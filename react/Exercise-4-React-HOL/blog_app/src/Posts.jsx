import React, { Component } from "react";
import Post from "./Post";

class Posts extends Component {

    constructor(props) {
        super(props);

        this.state = {
            posts: []
        };
    }

    loadPosts() {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then((response) => response.json())
            .then((data) => {
                const postList = data.map(
                    (item) => new Post(item.id, item.title, item.body)
                );

                this.setState({
                    posts: postList
                });
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert("Something went wrong while loading posts.");
        console.log(error);
        console.log(info);
    }

    render() {
        return (
            <div style={{ padding: "20px" }}>
                <h1>Blog Posts</h1>

                {this.state.posts.map((post) => (
                    <div
                        key={post.id}
                        style={{
                            marginBottom: "40px",
                            borderBottom: "2px solid gray",
                            paddingBottom: "5px"
                        }}
                    >
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;