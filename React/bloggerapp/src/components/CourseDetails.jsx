function CourseDetails() {

  const courses = [
    {
      id: 1,
      name: "ReactJS",
      duration: "6 Weeks"
    },
    {
      id: 2,
      name: "Spring Boot",
      duration: "8 Weeks"
    },
    {
      id: 3,
      name: "Java Full Stack",
      duration: "12 Weeks"
    }
  ];

  return (
    <>
      <h2>Course Details</h2>

      <ul>
        {courses.map(course => (
          <li key={course.id}>
            <b>{course.name}</b> - {course.duration}
          </li>
        ))}
      </ul>
    </>
  );
}

export default CourseDetails;