function BlogDetails() {
  const blogs = [
    {
      id: 1,
      title: 'React Learning',
      author: 'Stephen Biz',
      description: 'Welcome to learning React.'
    },
    {
      id: 2,
      title: 'Installation',
      author: 'Schwatz',
      description: 'You can install React from npm.'
    },
    {
      id: 3,
      title: 'React Components',
      author: 'John Doe',
      description: 'Components help split UI into reusable parts.'
    }
  ];

  return (
    <div className="details-card">
      <h2>Blog Details</h2>

      {blogs.map(blog => (
        <div className="item" key={blog.id}>
          <h3>{blog.title}</h3>
          <p><strong>Author:</strong> {blog.author}</p>
          <p>{blog.description}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;
