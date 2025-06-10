import { NextResponse } from 'next/server';

export async function GET() {
  try {
    const response = await fetch('http://localhost:8080/api/hello');
    const data = await response.text();
    
    return new NextResponse(data, {
      status: response.status,
      headers: {
        'Content-Type': 'text/plain',
      },
    });
  } catch (error) {
    return NextResponse.json(
      { error: 'Failed to fetch from Spring Boot server' },
      { status: 500 }
    );
  }
}