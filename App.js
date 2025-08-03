import React, { useState } from 'react';
import EmployeesList from './EmployeesList';
import ThemeContext from './ThemeContext';

import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

import './App.css';

function App() {
  const [theme, setTheme] = useState('light');
  const [view, setView] = useState('book'); 

  return (
    <ThemeContext.Provider value={theme}>
      <div className={`App ${theme}`} style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>📄 Blogger App with Theme and Employee List</h1>

        <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>
          Toggle Theme ({theme})
        </button>

        <hr />

        <div style={{ marginBottom: '20px' }}>
          <button onClick={() => setView('book')}>Show Book</button>{' '}
          <button onClick={() => setView('blog')}>Show Blog</button>{' '}
          <button onClick={() => setView('course')}>Show Course</button>{' '}
          <button onClick={() => setView('all')}>Show All</button>
        </div>

        {(() => {
          switch (view) {
            case 'book':
              return <BookDetails />;
            case 'blog':
              return <BlogDetails />;
            case 'course':
              return <CourseDetails />;
            case 'all':
              return (
                <>
                  <BookDetails />
                  <BlogDetails />
                  <CourseDetails />
                </>
              );
            default:
              return <p>Please select a valid view.</p>;
          }
        })()}

        <hr />


        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
