function BlogDetails() {

  const blogs = [
    {
      id: 1,
      title: "React Basics",
      author: "John"
    },
    {
      id: 2,
      title: "Understanding JSX",
      author: "David"
    },
    {
      id: 3,
      title: "Conditional Rendering",
      author: "Alex"
    }
  ];

  return (
    <>
      <h2>Blog Details</h2>

      <ul>
        {blogs.map(blog => (
          <li key={blog.id}>
            <b>{blog.title}</b> - {blog.author}
          </li>
        ))}
      </ul>
    </>
  );
}

export default BlogDetails;