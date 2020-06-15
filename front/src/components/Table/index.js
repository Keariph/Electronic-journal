import React from "react";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";

export default function TableVisit() {
  const date = ["01.01.1010", "02.02.2020"];
  var students = [
    ["Alex", "n", "n"],
    ["Boris", "v", "n"],
    ["Constans", "n", "v"],
    ["Daniel", "v", "v"],
  ];
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell align="center">ФИО</TableCell>
            {date.map((date, index) => (
              <TableCell align="center">{date}</TableCell>
            ))}
          </TableRow>
        </TableHead>
        <TableBody>
          {students.map((student, studentIndex) => (
            <TableRow key={studentIndex}>
              {student.map((info, index) => (
                <TableCell align="center" key={index}>
                  {info}
                </TableCell>
              ))}
            </TableRow>
          ))}
          <TableRow>
            
          </TableRow>
        </TableBody>
      </Table>
    </TableContainer>
  );
}
