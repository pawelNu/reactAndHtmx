import { useEffect } from "react";
import htmx from "htmx.org/dist/htmx";
import axios from "axios";

type Task = {
        id: number;
        name: string;
        subTasks: [
          {
            id: 0;
            name: string;
            task: string;
          }
        ]
}

export const TaskTable = () => {
    let data: Task[]

    useEffect(() => {
      const fetchData = async () => {
        try {
          const response = await axios.get("http://localhost:8080/api/tasks");
          data = response.data; // Dane z odpowiedzi
          console.log("Dane z odpowiedzi:", data);
        } catch (error) {
          console.error("Wystąpił błąd podczas pobierania danych:", error);
        }
      };
  
      fetchData(); // Wywołanie funkcji pobierającej dane
    }, []);
  
    return (
      <div>
        <h1>Lista zadań:</h1>
        <ul>
          {data.map((task, index) => (
            <li key={index}>{task.name}</li>
          ))}
        </ul>
      </div>
    );
  };
    
