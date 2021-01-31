library("ggplot2")

#unitility function to import a csv file.
import.csv <- function(filename) {
  return(read.csv(filename, sep = ",", header = TRUE))
}


df <- import.csv("geneticTTT.csv")
ggplot(data=df, aes(x=Generation, y=Lost, group=1)) +
  geom_line(colour = 'red') +
  geom_line(data = df, aes(x=Generation, y=Won), colour = 'green')+
  ylab("Games") +
  ggtitle("Strategy Evolution") 

# df1 <- df[,1:2]
# colnames(df1) <- c("Generation","Won")
# df1 <- rbind(df1,df[,c(1,3)])


