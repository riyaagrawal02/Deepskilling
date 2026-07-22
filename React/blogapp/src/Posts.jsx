import { Component } from "react";
import Post from "./Post";

class Posts extends Component {
  constructor(props) {
    super(props);

    this.state = {
      posts: []
    };
  }

  componentDidMount() {
    const data = [
      new Post(1, "React Introduction", "React is a JavaScript library."),
      new Post(2, "Component Lifecycle", "Lifecycle methods are important."),
      new Post(3, "Vite", "Vite is a modern build tool.")
    ];

    this.setState({
      posts: data
    });
  }

  componentDidCatch(error, info) {
    console.log("Error:", error);
    console.log("Info:", info);
  }

  render() {
    return (
      <div>
        <h1>Blog Posts</h1>

        {this.state.posts.map((post) => (
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;