defmodule Grades.Calculator do
  def letter_grade(grade_data) do
  # This is a basic example, please modify as necessary.
  final_grade = calculate_average_grade(grade_data)

  cond do
    final_grade >= 90 -> "A"
    final_grade >= 80 -> "B"
    final_grade >= 70 -> "C"
    final_grade >= 60 -> "D"
    final_grade >= 50 -> "E"
    true -> "F"
  end
end


  def percentage_grade(grade_data) do
    average_grade = calculate_average_grade(grade_data)
    "#{average_grade}%"
  end

  def numeric_grade(grade_data) do
    calculate_average_grade(grade_data)
  end

defp calculate_average_grade(grade_data) do
  grades = [grade_data[:final], grade_data[:midterm] | grade_data[:homework] ++ grade_data[:labs]]
  grades = Enum.filter(grades, fn grade -> grade != nil end) |> Enum.map(&String.to_integer/1)
  total = Enum.sum(grades)
  count = Enum.count(grades)

  if count > 0 do
    div(total, count)
  else
    0
  end
end



end
