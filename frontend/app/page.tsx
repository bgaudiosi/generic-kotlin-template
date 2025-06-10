'use client';

import { useEffect, useState } from 'react';

export default function Home() {
  const [message, setMessage] = useState<string>('Loading...');
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    async function fetchMessage() {
      try {
        const response = await fetch('/api/hello');
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.text();
        setMessage(data);
      } catch (err) {
        setError(err instanceof Error ? err.message : 'An error occurred');
        setMessage('Failed to load message');
      }
    }

    fetchMessage();
  }, []);

  return (
    <div className="min-h-screen flex items-center justify-center p-8">
      <main className="text-center">
        <h1 className="text-4xl font-bold mb-8">Spring Boot Integration</h1>
        {error ? (
          <div className="text-red-500">
            <p>Error: {error}</p>
            <p className="mt-2 text-sm">Make sure Spring Boot is running on localhost:8080</p>
          </div>
        ) : (
          <div className="text-2xl bg-gray-100 dark:bg-gray-800 p-4 rounded-lg">
            {message}
          </div>
        )}
      </main>
    </div>
  );
}
