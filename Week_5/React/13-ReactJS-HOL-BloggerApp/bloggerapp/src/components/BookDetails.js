function BookDetails() {
  const books = [
    {
      id: 1,
      name: 'Master React',
      price: 670
    },
    {
      id: 2,
      name: 'Deep Dive into Angular 11',
      price: 800
    },
    {
      id: 3,
      name: 'Mongo Essentials',
      price: 450
    }
  ];

  return (
    <div className="details-card">
      <h2>Book Details</h2>

      {books.map(book => (
        <div className="item" key={book.id}>
          <h3>{book.name}</h3>
          <p>Price: Rs. {book.price}</p>
        </div>
      ))}
    </div>
  );
}

export default BookDetails;
