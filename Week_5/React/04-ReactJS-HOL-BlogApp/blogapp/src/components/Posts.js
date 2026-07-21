import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);

    this.state = {
      posts: [],
      message: 'Loading blog posts...'
    };
  }

  componentDidMount() {
    const fallbackPosts = [
      {
        id: 1,
        title: 'React Components',
        body: 'Components help split the user interface into reusable pieces.'
      },
      {
        id: 2,
        title: 'React State',
        body: 'State is used to store data that can change inside a component.'
      },
      {
        id: 3,
        title: 'React Lifecycle',
        body: 'Lifecycle methods allow code to run at different stages of a component.'
      }
    ];

    fetch('https://jsonplaceholder.typicode.com/posts?_limit=3')
      .then(response => response.json())
      .then(data => {
        this.setState({
          posts: data,
          message: 'Blog Posts'
        });
      })
      .catch(() => {
        this.setState({
          posts: fallbackPosts,
          message: 'Blog Posts'
        });
      });
  }

  render() {
    return (
      <div>
        <h1>{this.state.message}</h1>

        {this.state.posts.map(post => (
          <Post key={post.id} post={post} />
        ))}
      </div>
    );
  }
}

export default Posts;
