function BookDetails() {

  const books = [
    {
      id: 1,
      name: "Clean Code",
      author: "Robert C. Martin"
    },
    {
      id: 2,
      name: "Effective Java",
      author: "Joshua Bloch"
    },
    {
      id: 3,
      name: "Head First Java",
      author: "Kathy Sierra"
    }
  ];

  return (
    <>
      <h2>Book Details</h2>

      <ul>
        {books.map(book => (
          <li key={book.id}>
            <b>{book.name}</b> - {book.author}
          </li>
        ))}
      </ul>
    </>
  );
}

export default BookDetails;