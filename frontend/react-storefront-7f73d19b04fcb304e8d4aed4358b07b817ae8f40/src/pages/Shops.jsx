import { useEffect, useState } from "react"

function Shops() {
        const [books, setBooks] = useState([]);

        useEffect(() => {
        async function fetchBibles() {
            try {
                const data = await fetch("http://localhost:8080/api/bibles");
                const fetchData = await data.json();
                setBooks(fetchData.slice());
            } catch (e) {
                console.error("Unable to fetch", e);
            }
            }
            fetchBibles();
    }, []);
  return (
        <div>
        {books.map(book => 
            <div>
                <div>{book.type}</div>
                <div>{book.description}</div>
                <br />
            </div>)}
    </div>
  )
}

export default Shops