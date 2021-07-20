import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';

const apiURL = 'http://worldclockapi.com/api/json/utc/now';

function App() {

  const [post, setPost] = useState(null);

  useEffect(() => {
    axios.get(apiURL)
      .then((response) => {
        setPost(response.data);
      });
  }, []);

  if(!post) return null;

  return (
    <div className='App'>
      <h1 className='container h1'>{post.currentDateTime}</h1>
      <h2>{post.dayOfTheWeek}</h2>
      
      
    </div>
  );
}

export default App;
