import { useState } from "react";
import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {

  const [page, setPage] = useState("book");

  let component;

  if (page === "book") {
    component = <BookDetails />;
  } else if (page === "blog") {
    component = <BlogDetails />;
  } else {
    component = <CourseDetails />;
  }

  return (
    <div>

      <h1>Blogger App</h1>

      <button onClick={() => setPage("book")}>
        Books
      </button>

      <button onClick={() => setPage("blog")}>
        Blogs
      </button>

      <button onClick={() => setPage("course")}>
        Courses
      </button>

      <hr />

      {component}

    </div>
  );
}

export default App;