import './App.css';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const showBookDetails = true;
  const showBlogDetails = true;
  const showCourseDetails = true;

  return (
    <div className="App">
      <h1>Blogger App</h1>

      <div className="details-container">
        {showBookDetails && <BookDetails />}
        {showBlogDetails ? <BlogDetails /> : null}
        {showCourseDetails ? <CourseDetails /> : null}
      </div>
    </div>
  );
}

export default App;
