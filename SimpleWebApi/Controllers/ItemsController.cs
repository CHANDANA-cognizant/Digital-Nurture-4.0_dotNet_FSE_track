using Microsoft.AspNetCore.Mvc;
using SimpleWebApi.Models;
using System.Collections.Generic;
using System.Linq;

namespace SimpleWebApi.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class ItemsController : ControllerBase
    {
        private static List<Item> items = new List<Item>
        {
            new Item { Id = 1, Name = "Item One" },
            new Item { Id = 2, Name = "Item Two" }
        };

        // GET: api/items
        [HttpGet]
        public ActionResult<IEnumerable<Item>> Get()
        {
            return Ok(items);
        }

        // GET: api/items/1
        [HttpGet("{id}")]
        public ActionResult<Item> Get(int id)
        {
            var item = items.FirstOrDefault(i => i.Id == id);
            if (item == null)
                return NotFound();
            return Ok(item);
        }

        // POST: api/items
        [HttpPost]
        public ActionResult<Item> Post([FromBody] Item newItem)
        {
            newItem.Id = items.Count + 1;
            items.Add(newItem);
            return CreatedAtAction(nameof(Get), new { id = newItem.Id }, newItem);
        }

        // PUT: api/items/1
        [HttpPut("{id}")]
        public IActionResult Put(int id, [FromBody] Item updatedItem)
        {
            var item = items.FirstOrDefault(i => i.Id == id);
            if (item == null)
                return NotFound();

            item.Name = updatedItem.Name;
            return NoContent();
        }

        // DELETE: api/items/1
        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            var item = items.FirstOrDefault(i => i.Id == id);
            if (item == null)
                return NotFound();

            items.Remove(item);
            return NoContent();
        }
    }
}
