import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  
  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => this.setState({ posts: data }))
      .catch(error => {
        console.error("Error fetching posts", error);
        this.setState({ hasError: true });
      });
  };

  
  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert('Something went wrong!');
    console.error("Error caught:", error, info);
    this.setState({ hasError: true });
  }

 
  render() {
    if (this.state.hasError) {
      return <h1>Error occurred while loading posts.</h1>;
    }

    return (
      <div>
        <h2>Posts</h2>
        {this.state.posts.map(post => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;
