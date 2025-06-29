using NUnit.Framework;
using Moq;
using MagicFilesLib;
using System.Collections.Generic;

namespace DirectoryExplorer.Tests
{
    [TestFixture]
    public class DirectoryExplorerTests
    {
        private readonly string _file1 = "file.txt";
        private readonly string _file2 = "file2.txt";

        [Test]
        public void GetFiles_ReturnsExpectedFiles()
        {
            // Arrange
            var mock = new Mock<IDirectoryExplorer>();
            mock.Setup(x => x.GetFiles(It.IsAny<string>()))
                .Returns(new List<string> { _file1, _file2 });

            // Act
            var result = mock.Object.GetFiles("dummy_path");

            // Assert
            Assert.IsNotNull(result);
            Assert.AreEqual(2, result.Count);
            CollectionAssert.Contains(result, _file1);
        }
    }
}
