function Post(props) {
  return (
    <div className="post-card">
      <h2>{props.post.title}</h2>
      <p>{props.post.body}</p>
    </div>
  );
}

export default Post;
