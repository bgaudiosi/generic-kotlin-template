import React, { useState, useEffect } from 'react';
import './index.css';

interface ApiResponse {
  message: string;
}

function App() {
  const [message, setMessage] = useState<string>('');
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string>('');

  useEffect(() => {
    fetch('/api/hello')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data: ApiResponse) => {
        setMessage(data.message);
        setLoading(false);
      })
      .catch(error => {
        setError('Failed to fetch message from app');
        setLoading(false);
        console.error('Error:', error);
      });
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Generic Kotlin Template</h1>
        <p>Spring Boot Kotlin + React TypeScript</p>
      </header>
      
      <main>
        <h2>Message from App:</h2>
        {loading && <p className="message loading">Loading...</p>}
        {error && <p className="message error">{error}</p>}
        {message && !loading && !error && (
          <p className="message">{message}</p>
        )}
      </main>
    </div>
  );
}

export default App;
